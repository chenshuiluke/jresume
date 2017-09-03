console.log("Printing PDF");
var system = require('system');
console.log("Commandline arguments: " + system.args);
console.log("Number of commandline arguments: " + system.args.length);
if(system.args.length < 3){
	console.log("Please supply the input html resume and the output pdf file.");
	phantom.exit();
}
else{
	console.log("You have enough arguments!");
	var page = require('webpage').create();
	var htmlFile = system.args[1];
	var outputPdfFile = system.args[2];

	page.paperSize = {
		format: 'Letter',
		orientation: 'portrait',
		margin: '0.4in'
	};


	page.open(htmlFile, function(status){
		if(status !== 'success'){
			console.log("Failed to load page!");
			phantom.exit();
		}
		else{
			console.log("Successfully loaded page!");
			page.render(outputPdfFile, {
				format: "pdf"
			});
			phantom.exit();
		}
	});
}
