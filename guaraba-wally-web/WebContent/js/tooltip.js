jQuery(document).ready(function() { 
        jQuery(".js_hoverData").hide();
        jQuery(".js_hoverLauncher").live("mouseover", function() {
            jQuery(".js_hoverData", jQuery(this).parent()).show();
        });
        jQuery(".js_hoverLauncher").live("mouseout", function() {
            jQuery(".js_hoverData", jQuery(this).parent()).hide();
        });
        jQuery(".js_hoverLauncher").live("mousemove", function(e) {
            var off = jQuery(this).offset();
            var pos = jQuery(this).position();
            jQuery(".js_hoverData", jQuery(this).parent()).css({
                "position":"absolute",
                "top":e.pageY - off.top + pos.top +10,
                "left":e.pageX - off.left + pos.left +10
            });
        });
        
        jQuery(".js_noLink").live("click", function() {
            return false;
        });
    });
