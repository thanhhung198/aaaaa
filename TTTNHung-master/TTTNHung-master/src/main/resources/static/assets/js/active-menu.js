$('document').ready(function () {
    let pathname = $(location).attr('pathname');
    $("#menu li").each(function(index) {
        let a = $(this).find('a');
        let href = a.attr('href');
        if(href == pathname){
            let classThis = $(this).attr('class') + " active";
            $(this).attr('class',classThis);
            let parent= $(this).parent();
            if(parent.attr('class').toString().indexOf("submenu") >= 0){
                parent.attr('class', 'submenu nav-show');
                parent.attr('style','display: block;');
                parent= parent.parent();
                parent.attr('class','open active');
            }
        }
    })
});