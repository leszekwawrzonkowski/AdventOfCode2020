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

$("#buttonD1").click(function(e) {
	$("#buttonD1").prop('disabled', true);
	$.when(
		sendAsyncJsonPostReqWithData("day-one-part-one", $("textarea#textareaD1").val()),
		sendAsyncJsonPostReqWithData("day-one-part-two", $("textarea#textareaD1").val())
	)
	.done(function(resultD1P1, resultD1P2) {
		$("input#inputSolutionD1P1").val(resultD1P1[0]);
		$("input#inputSolutionD1P2").val(resultD1P2[0]);
	})
	.fail(function() {
		$("input#inputSolutionD1P1").val("");
		$("input#inputSolutionD1P2").val("");
	})
	.always(function() {
		$("#buttonD1").prop('disabled', false);
	});

});
