$.rvFontsize({
	targetSection: '*',
    store: true, // store.min.js required!
    controllers: {
        appendTo: '#rvfs-controllers',
        showResetButton: true
    }
}); 

function contrast() {
	if($('body').css("background-color") === "rgb(190, 190, 190)") {
		$('body').css({'background': "#fff"});
		$('a.btn').css({'background': "#fff",'color': "#333",'border-color': "#ccc"});
		$('a.btn-success').css({'background': "#5cb85c",'color': "#fff", 'border-color': "#4cae4c"});
		$('.btn-primary').css({'background': "#337ab7",'color': "#fff", 'border-color': "#2e6da4"});
	} else {
		$('body').css({'background': "#BEBEBE"});
		$('a.btn').css({'background': "#333",'color': "#fff"});
		$('a.btn-success').css({'background': "#333",'color': "#fff", 'border-color': "#fff"});
		$('.btn-primary').css({'background': "grey",'color': "#fff", 'border-color': "#fff"});
		
	}	
}