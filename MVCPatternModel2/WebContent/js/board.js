/**
 * 
 */
function search(){
	
};

function write(){
	$('#registFreeboard').click(function(){
		if(eval('${empty LOGIN_MEMBERINFO}')){
			BootstrapDialog.show({
			    title: '경고',
			    message: '로그인 후 게시글 등록이 가증합니다.'
			});
			return;
		}
		$(location).attr('href','${pageContext.request.contextPath}/user/mainTamplate.jsp');
	});
};
function insertBtn(){
	$('#insertBtn').cilck(function(){
//		if(eval('${empty LOGIN_MEMBERINFO}')){
//			BootstrapDialog.show({
//			    title: '경고',
//			    message: '로그인 후 게시글 등록이 가증합니다.'
//			});
//			return;
//		}
		return $(location).attr('href','${pageContext.request.contextPath}/user/freeboard/freeboardForm.jsp');
	});
	
	
};

function listClick(){
	$('#freeboardTbl tr:gt(0)').click(function(){
		var bo_no = $(this).find('td:eq(0) input').val();
		var rnum = $(this).find('td:eq(0)').text();
		$(location).attr('href','${pageContext.request.contextPath}/12/main.jsp?contentPage=/12/freeboard/freeboardView.jsp?bo_no='+bo_no+'&rnum='+rnum);
	});
};