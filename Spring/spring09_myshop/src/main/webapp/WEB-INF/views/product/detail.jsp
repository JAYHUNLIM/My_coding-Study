<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<link href="/css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="/js/jquery-3.6.4.min.js"></script>


<!-- onclick 함수 -->
<script>
function product_delete() {
    if (confirm("영구히 삭제됩니다.\n 진행 할까요")) {     
    document.productfrm.action="/product/delete";
    document.productfrm.submit();
    }
}

//

function product_update() {
    document.productfrm.action="/product/update";
    document.productfrm.submit();
    
}

function product_cart() {
    if ($("#qty").val()=="0") {
        alert("수량을 선택하세요");
    }else{
        document.productfrm.action="/cart/insert";
        document.productfrm.submit();
    }
}

</script>


</head>
<body>
<h3>상품수정/삭제/상세보기</h3>
<p>
&nbsp; <button type="button" onclick="location.href='/product/list'" class="btn btn-success">상품 전체목록</button>
</p>

<form name="productfrm" id="productfrm" method="post" enctype="multipart/form-data">
<table border="1" class="table table-striped">
    <tr>
        <td>상품명</td>
        <td> <input type="text" name="product_name" value="${product.PRODUCT_NAME}"> </td>
    </tr>
    <tr>
        <td>상품가격</td>
        <td> <input type="number" name="price" value="${product.PRICE}" > </td>
    </tr>
    <tr>
        <td>상품설명</td>
        <td> 
            <textarea rows="5" cols="60" name="description">${product.DESCRIPTION}</textarea>     
         </td>
    </tr>
    <tr>
        <td>상품사진</td>
		<td>
		<c:if test="${product.FILENAME !='-'}">
			<img src="/storage/${product.FILENAME}" width="100px">
		</c:if> 
		<input type="file" name="img"></td>
		</tr>
		<tr>
		<td>상품수량</td>
		<td>
		 <select name="qty" id="qty">
		 <option value="0">#선택#</option>
		 <option value="1">1</option>
		 <option value="2">2</option>
		 <option value="3">3</option>
		 <option value="4">4</option>
		 <option value="5">5</option>
		</select>
		 </td>
		</tr>
    <tr>
	   <td colspan="2" align="center">
	   <input type="hidden" name="product_code" value="${product.PRODUCT_CODE}">
	   <input type="button" value="상품수정" class="btn btn-info" onclick="product_update()">
	   <input type="button" value="상품삭제" class="btn btn-warning" onclick="product_delete()">
	   <input type="button" value="구매하기" class="btn btn-warning" onclick="product_cart()">
</td>
</tr>
</table>
</form>
<hr>
<!-- 댓글 -->
<div id="comment" style="padding-left:15px; font-size: 15px;">
<label for="content">댓글</label>
<form id="commentInsertForm" name="commentInsertForm">
	<div>
<input type="hidden" name="product_code" value="${product.PRODUCT_CODE}">
<input type="text" name="content" id="content" placeholder="댓글을 입력해주세요" autofocus>
<button type="button" name="commentInsertBtn" id="commentInsertBtn" class="btn btn-default">등록</button>
	</div>
</form>
	</div>

<!-- 댓글 목록 -->
<div id="clist" style="padding: 15px; padding-top: 10px; padding-bottom: 10px; color: blueviolet; font-size: large;">
<div class="commentList"></div>
</div>

<script>

let product_code='${product.PRODUCT_CODE}';



//댓글 등록 버튼을 클릭한 경우
$("#commentInsertBtn").click(function(){
	//alert($);
    let insertData=$("#commentInsertForm").serialize();
   // alert(insertData);//product_code=7&content=11111111 부모글 번호, 내용

   //댓글 등록함수 호출
   commentInsert(insertData);
});

function commentInsert(insertData) {
    //alert("댓글 등록 함수"+insertData);
    $.ajax({url:'/comment/insert', //요청 명령어 등록
    type:'post', //넘기는방식
    data:insertData,
    error:function(error){
        alert(error);
    },
    success:function(data){
       //alert(data);
       if (data==1) {
        //전달 받은 데이터 값이 1 -> 댓글 등록이 성공한 경우
        commentList(); // 댓글 작성후 목록으로 이동

        //기존 댓글 내용을 빈 문자열로 대입
        $("#content").val('');

       }
    }});
}

function commentList() {
   // alert("댓글 목록 호출");

   // product_code 전달
    $.ajax({url:'/comment/list',
    type:'get',
    data:{'product_code':product_code},        // 넘기는 항목이 여러개 {}
    success:function(data){
        //alert(data);

        let a='';//출력할 결과 값  모두 a에 모은다

        $.each(data,function(key,value) {
            //alert(key);//0 1 2
            //alert(value);//[object object]
            
            /*  댓글 내용 확인
            alert(value.cno);
            alert(value.content);
            alert(value.wname);
            alert(value.regdate);
            alert(value.product_code);
            */

            
            //하나의 댓글당 div 작업
           a +='<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom:15px;">'     
            // 댓글번호 + div
           a +='<div class="commentInfo'+value.cno+'">'
           a +='댓글번호:'+value.cno +' / 작성자:'+value.wname+" "+value.regdate;
           a += '<a href="javascript:commentUpdate('+value.cno+',\''+value.content+'\')">[수정]</a>'+" ";
           a +='<a href="javascript:commentDelete('+value.cno+')">[삭제]</a>'; 
           a +='</div>' 
           //댓글 내용 div
           a +='<div class="commentContent'+value.cno+'">'         
           a +='<p> 내용: '+ value.content +"</p>";
           a +='</div>'
           a +='</div>'


        });
        $(".commentList").html(a);
    }});

}// ////////////////////////////

$(document).ready(function() {
   commentList(); 
   //상세목록 페이지로 들어온 경우 댓글목록 출력하기
});

/////////////////////////////댓글 삭제
//pk값 넘기기
function commentDelete(cno) {
 //   alert(cno);
 //댓글을 삭제하고 원래 위치로 돌아오기
 $.ajax({
    url:'/comment/delete/'+cno,  //  /comment/delete/+3
    type:'post',
    success:function(data){
        //alert(data);
        if (data==1) {
            commentList();
        }
    }
 });
}
////////댓글 수정
//댓글 내용을 input에 출력
function commentUpdate(cno,content) {
    //alert(cno+content);
    let a='';
    a+='<div class="input-group">';
    a +='<input type="text" value="'+content+'" id="content'+cno +'">';
    a +='<button type="button" class="btn btn-default" onclick="commentUpdateProc('+cno+')">수정</button>';
    a+='</div>';
   // alert(a);
   //div class=commentContent에 댓글 내용 출력
   $(".commentContent"+cno).html(a);
}
function commentUpdateProc(cno) {
    //let updateContent=$('[name=content_'+cno+']');
    let updateContent=$('#content'+cno).val();
    //alert(cno);
    $.ajax({
        url:'/comment/update',
        type:'post',
        data:{'content':updateContent,'cno':cno},
        success:function(data){
            if (data==1) {
                commentList();
            }
        }
    });
}


</script>
</body>
</html>