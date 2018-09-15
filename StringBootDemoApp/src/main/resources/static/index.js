window.onload = function() {
	console.log("Javascript Loaded");
    $("#compute-distance").on("click",function(){ 
    	console.log("Compute Button Pressed");
    	var start = $('#start-word').val();
    	var end = $('#end-word').val();
    	
        $.ajax({ 
            type:"GET", 
            url:"/StringDistance", 
            data: {
			        'start':start,
			        'end':end,
			      },
            success:function(data){ 
                $("#distance-result").text("Distance was: " + data.distance)
            },
            cache: false
        }); 
    });
}