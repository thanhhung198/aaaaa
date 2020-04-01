package com.caigicungco.controller;

import com.caigicungco.DTO.CPUDTO;
import com.caigicungco.DTO.ElectronicDTO;
import com.caigicungco.DTO.GPUDTO;
import com.caigicungco.DTO.ProducerDTO;
import com.caigicungco.constant.product.ElectronicType;
import com.caigicungco.service.CPUService;
import com.caigicungco.service.ElectronicService;
import com.caigicungco.service.GPUService;
import com.caigicungco.service.ProducerService;
import com.caigicungco.utils.FileUtils;
import com.caigicungco.utils.JsonConver;
import com.caigicungco.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class UploadElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private CPUService cpuService;

    @Autowired
    private GPUService gpuService;

    private Map<String, CPUDTO> mapCpu;

    private Map<String, GPUDTO> mapGpu;

    @Autowired
    private FileUtils fileUtils;

    public void reloadMapGPU(HttpSession session){
        mapGpu = (Map<String, GPUDTO>) session.getAttribute("mapGpu");
        if(mapGpu == null){
            mapGpu = gpuService.findAllKeyName();
            session.setAttribute("mapGpu",mapGpu);
        }else{
            session.setAttribute("mapGpu",mapGpu);
        }
    }

    public void reloadMapCPU(HttpSession session){
        mapCpu = (Map<String, CPUDTO>) session.getAttribute("mapCpu");
        if(mapCpu == null){
            mapCpu = cpuService.findAllKeyName();
            session.setAttribute("mapCpu",mapCpu);
        }else{
            session.setAttribute("mapCpu",mapCpu);
        }
    }




    @RequestMapping(value = "/admin/load/electronic")
    public String view(Model model,HttpSession session){

        model.addAttribute("producers",producerService.finAll());
        List<String> types = Arrays.stream(ElectronicType.values()).map(Objects::toString).collect(Collectors.toList());
        model.addAttribute("types", types);
        reloadMapGPU(session);
        reloadMapCPU(session);

        return  "electronic/upload";
    }



    @PostMapping(value = "/admin/load/electronic")
    public String upload(@RequestParam("files") MultipartFile[] files,
                         @RequestParam("producer") Long producerId,
                         @RequestParam(value = "check",defaultValue = "false") boolean check,
                         @RequestParam(value = "type") String type,
                         HttpSession session
                         ){


        Optional<ElectronicType> typeEnum = Arrays.stream(ElectronicType.values()).filter(item ->{
            return item.Value().equalsIgnoreCase(type);
        }).findAny();
        if(!typeEnum.isPresent()){
            return "redirect:/admin/load/electronic?erro=type";
        }

        System.out.println(files.length);
        Arrays.stream(files).forEach(file->{
            ElectronicDTO[] electronics = null;

            try {
                InputStream inputStream = file.getInputStream();

                String json = fileUtils.inputStreamToString(inputStream);

                electronics = new JsonConver(json).toObject(ElectronicDTO[].class);

            } catch (IOException e) {
                e.printStackTrace();
            }

            if(electronics != null){
                boolean isAdd = true;
                reloadMapGPU(session);
                reloadMapCPU(session);
                if(check){
                    String producerName = StringUtils.removeTypeFile(file.getOriginalFilename());
                    ProducerDTO producer = producerService.addByJson(producerName);
                    Arrays.stream(electronics).forEach(item ->{item.setProducer(producer);});
                } else if(producerId != null){
                    Arrays.stream(electronics).forEach(item->{item.setProducer(new ProducerDTO(producerId));});
                }else{
                    isAdd = false;
                }
                if(isAdd){
                    Arrays.stream(electronics).forEach(item->{
                        item.setType(typeEnum.get().Value());
                        if(item.getCpu() != null){
                            CPUDTO cpudto = item.getCpu();

                            if(cpudto.getId() == null || cpudto.getName()!= null){
                                if(mapCpu.containsKey(cpudto.getName())){
                                    cpudto = mapCpu.get(cpudto.getName());
                                }else{
                                    cpudto = cpuService.add(cpudto,"admin");
                                    mapCpu.put(cpudto.getName(),cpudto);
                                    reloadMapCPU(session);
                                }
                            }
                            item.setCpu(cpudto);
                        }

                        if(item.getGpu() != null){
                            GPUDTO gpudto = item.getGpu();

                            if(gpudto.getId() == null || gpudto.getName()!= null){
                                if(mapGpu.containsKey(gpudto.getName())){
                                    gpudto = mapGpu.get(gpudto.getName());
                                }else{
                                    gpudto = gpuService.add(gpudto,"admin");
                                    mapGpu.put(gpudto.getName(),gpudto);
                                    reloadMapGPU(session);
                                }
                            }
                            item.setGpu(gpudto);
                        }

                    });

                    electronicService.addAll(Arrays.asList(electronics));
                }
            }

        });



        return "redirect:/admin/load/electronic";
    }

}
