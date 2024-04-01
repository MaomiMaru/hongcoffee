<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홍커피</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/imgs/logo.png" />
<style>
div{
	display: inline-block; width: 100px
}
select{
	width: 177px;
}
.box-body{
	display: inline-block;
}
.input-group{
	display: inline-block;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/store/popup/stock_insertPro" method="post" class="form">
<h2 style="margin-left: 10px">재고 추가</h2>
<fieldset style="border:0px">
<div class="check"></div><br>
<div class="box-body">
<div><b>유형</b></div>
<div class="input-group">
<select class="form-control" style="width: 177px" name="item_type">
<option value="100">선택해주세요</option>
<option value="0">식품</option>
<option value="1">비식품</option>
</select>
</div>
<sub></sub><br>
<div><b>재료명</b></div>	
<div class="input-group">
<select class="form-control" name="item_name" id="item_name">
<option value="">선택해주세요</option>
</select>
</div>
</div>
<br>
<div><b>단가</b></div><input type="text" name="item_price" id="item_price" readonly><br>
<div><b>발주량</b></div><input type="text" name="od_amount"><br>
<div><b>적요</b></div><input type="text" name="od_note"><br>
<br>
<input type="submit" value="추가하기">
</fieldset>
</form>

<script type="text/javascript">
$(function(){
    $('select[name="item_type"] ').on('change', function()  {
        let arrType = getAgreeType();
        let optionType = $(this).parents('.box-body').find($('select[name="item_name"]'));
        optionType.empty();

        if($(this).val() == '0'){ 
            for(prop in arrType['식품']){
                optionType.append('<option value='+prop+' >'+arrType['식품'][prop]+'</option>');
            }
        }else{                            
            for(prop in arrType['비식품']){
                optionType.append('<option value='+prop+' >'+arrType['비식품'][prop]+'</option>');
            } 
        }
        });
        
        
	$('#item_name').change(function(){
// 		var selectedValue = $('#item_name').val();
		if($('#item_name').val()=="에티오피아"||$('#item_name').val()=="콜롬비아"){
			$('#item_price').val(3500);
		}else{
			$('#item_price').val(10);
		}
	
    });
});

function getAgreeType() {    
    var obj = {
        "식품" : {
            '에티오피아' : '에티오피아',
            '콜롬비아' : '콜롬비아',
        },
        "비식품" : {
            '유리컵M' : '유리컵M',
            '유리컵L' : '유리컵L',
            '종이컵M' : '종이컵M',
            '종이컵L' : '종이컵L',
            '플라스틱컵M' : '플라스틱컵M',
            '플라스틱컵L' : '플라스틱컵L',
            '컵홀더' : '컵홀더',
            '스트로우M' : '스트로우M',
            '스트로우L' : '스트로우L',
            '버블티스트로우' : '버블티스트로우',
            '2컵캐리어' : '2컵캐리어',
            '4컵캐리어' : '4컵캐리어',
        }
        
    }
    return obj;
    
}

// function showPrice(){
	
// 	  var material = document.getElementById("item_name").value;
// 	  var priceInput = document.getElementById("item_price");
	
// 	var price = 0;
// 	if(material=="에티오피아"||material=="콜롬비아"){
// 		price = 3500;
// 	} else{
// 		price = 10;
// 	}
// 	$('item_price').val(price);
// }







</script>
</body>
</html>