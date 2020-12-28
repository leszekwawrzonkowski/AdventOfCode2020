function sendAsyncJsonPostReqWithData(reqUrl, reqData) {
	var TIMEOUT = 10000;

	return $.ajax({
		url: reqUrl,
		contentType: 'text/plain',
		type: "POST",
		data: reqData,
		timeout: TIMEOUT,
		async: true
	});
};

$("button").click(function() {
	var id = this.id;
	if (id.startsWith("button-")) {
		var day = this.id.split("-")[1];
		$("#" + id).prop('disabled', true);
		$.when(
			sendAsyncJsonPostReqWithData("api-" + day + "-P1", $("#textarea-" + day).val()),
			sendAsyncJsonPostReqWithData("api-" + day + "-P2", $("#textarea-" + day).val())
		)
		.done(function(resultP1, resultP2) {
			$("#input-" + day + "-P1").val(resultP1[0]);
			$("#input-" + day + "-P2").val(resultP2[0]);
		})
		.fail(function() {
			$("#input-" + day + "-P1").val("");
			$("#input-" + day + "-P2").val("");
		})
		.always(function() {
			$("#" + id).prop('disabled', false);
		});
	}
});
