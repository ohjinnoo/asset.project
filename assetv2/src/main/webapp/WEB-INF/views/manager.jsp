<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Style-Type" content="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="css/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body{
			background: #ecf0f5;
		}
		tbody{
			background: #ffffff;
		}
	</style>
	
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="/js/common.js" type="text/javascript"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	<script src="/js/gijgo.js" type="text/javascript"></script>
  	<script src="js/jquery.serializeObject.js" type="text/javascript"></script>
  	<script type="text/javascript">
  	var position_data = new Array();
    var dept_data = new Array();
    var office_data = new Array();
    var dept_val = new Array();
    var position_val = new Array();
    var office_val = new Array();
    var country_val = new Array();
    var country_data = new Array();
    
   	<c:forEach items="${common.position}" var="position">
    	position_data.push("${position.cName}");
    	position_val.push("${position.cCode}")
    </c:forEach>
    <c:forEach items="${common.country}" var="country">
    	country_data.push("${country.cName}")
    	country_val.push("${country.cCode}")
    </c:forEach>
    	 <c:forEach items="${common.office}" var="office">
     	office_data.push("${office.cName}")
     	office_val.push("${office.cCode}")
     </c:forEach>
    
    <c:forEach items="${dept}" var="dept">
    	var num ='';
    	for(var i=1;i<${dept.level};i++){
    		num += "&nbsp;&nbsp;"
    	}
    	dept_data.push(num+"${dept.dept_nm}"+" ${dept.org_nm}");
    	dept_val.push("${dept.dept_no}")
    </c:forEach>
      
  	</script>
  	<script src="/js/manager.js" type="text/javascript"></script>
</head>
<body>
    <div class="container-fluid">
        <div class="row" style="background: #ffffff">
            <div class="col-9">
            <input type="hidden" id="mgrAuth" value="${mgr.auth }">
                <form class="form-inline" id="srchForm" onsubmit="return false">
                	
                	<select id="keyword" class="form-control mb-2 mr-sm-2 mb-sm-0">
                		<option value="">선택</option>
                		<option value="name">이름</option>
                		<option value="country">사업국가</option>
                		<option value="dept">부서</option>
                		<option value="position">직위</option>
                		<option value="office">사무실</option>
                		<option value="status">상태</option>
                		<c:if test="${mgr.auth==1 }">
                		<option value="manager">계정</option>
                		</c:if>
                	</select>
                	<span id="s"></span>
                     <button id="btnSearch" type="button" class="btn btn-default">Search</button> &nbsp;
               		 <button id="btnClear" type="button" class="btn btn-default">Clear</button>
                </form>
            </div>
            <div class="col-3">
                <button id="btnAdd" type="button" class="btn btn-default pull-right">New</button>
            </div>
        </div>
        <div class="box box-primary" style="margin-top: 10px">
            <div class="col-12">
                <table id="grid"></table>
            </div>
        </div>
    </div>

    <div id="regist">
        <form id="regForm">
        	<input type="hidden" id="basic_dept" name="basic_dept">
        	<input type="hidden" id="division" name="division">
            <div class="form-group">
                <label for="empNo">사번</label>
                <input type="text" class="form-control" id="empNo" name="empNo">
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" class="form-control" id="name" name="name"/>
            </div>
             <div class="form-group">
                <label for="position">직위</label>
                <select class="form-control" id="position" name="position">
	                <option value=""></option>
	                <c:forEach var="position" items="${common.position }">
	                	<option value="${position.cCode }">${position.cName }</option>
	                </c:forEach>
                </select>

            </div>
            <div class="form-group">
                <label for="country">사업국가</label>
                <select class="form-control" id="country" name="country">
                <option value="">선택하세요</option>
	                <c:forEach var="country" items="${common.country }">               	
	                		<option value="${country.cCode }">${country.cName }</option>
                </c:forEach>
                </select>

            </div>
             <div class="form-group">
                <label for="division">부서</label>
                <select class="form-control dept" id="first_dept" name="first_dept">
	                <option value="">## NONE ##</option>
                </select>
            </div>
             <div class="form-group">
              <select class="form-control dept" id="second_dept" name="second_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
              <div class="form-group">
              <select class="form-control dept" id="three_dept" name="three_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
              <div class="form-group">
              <select class="form-control dept" id="four_dept" name="four_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
            <div class="form-group ga_only">
                <label for="office_number">사무실전화번호</label>
                <input type="tel" class="form-control" name="office_number" id="office_number" maxlength="12">
            </div>
            <div class="form-group">
                <label for="seat">좌석</label>
                <div role="wrapper" class="gj-datepicker gj-datepicker-md gj-unselectable">
                <input type="text" class="form-control gj-textbox-md seat" id="seat" name="seat" role="input">
                <i class="fa fa-map-marker seatMap" role="right-icon"></i>
                </div>    	
            </div>
             <div class="form-group">
                <label for="gender">성별</label>
                <select class="form-control" id="gender" name="gender">
                	<option value="M">남성</option> 
					<option value="F">여성</option>       
                </select>
            </div>
             <div class="form-group">
                <label for="email">이메일</label>
                <input type="text" class="form-control" id="email" name="email" value="@qoo10.com"/>
            </div>
            <div class="form-group">
                <label for="joinDate">입사일</label>
                <input type="text" class="form-control" id="joinDate" name="joinDate"/>
            </div>
            <button type="button" id="btnSave" class="btn btn-default">Save</button>
            <button type="button" id="btnCancel" class="btn btn-default">Cancel</button>
        </form>
    </div>
    <div id="modify">
        <form id="mdfForm" enctype="multipart/form-data">
        	
            <input type="hidden" class="form-control" id="eempNo" name="empNo">
            <input type="hidden" class="form-control" id="eemail" name="email">
            <input type="hidden" class="form-control" id="original_name">
            <input type="hidden" class="form-control" id="isManager">
            <input type="hidden" id="ebasic_dept" name="basic_dept">
            <input type="hidden" id="edivision" name="division">  
            <div class="form-group" style="text-align: center;">  
	       		<img alt="사진" src="/images/profileImage/default_profile.jpg" width="150px" height="170px" id="profile">
	        </div>
            <div class="form-group">
                <label for="ename">이름</label>
                <input type="text" class="form-control" id="ename" readonly="readonly" name="name"/>
            </div>
             <div class="form-group">
                <label for="eposition">직위</label>
                <select class="form-control" id="eposition" name="position">
                	<option value=""></option> 
	                <c:forEach var="position" items="${common.position }">
	                	<option value="${position.cCode }">${position.cName }</option>
	                </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="country">사업국가</label>
                <select class="form-control" id="ecountry" name="country">
	                <option value="">선택하세요</option>
	                <c:forEach var="country" items="${common.country }">
	                	<option value="${country.cCode }">${country.cName }</option>
	                </c:forEach>
                </select>

            </div>
             <div class="form-group">
                <label for="division">부서</label>
                <select class="form-control dept" id="efirst_dept" name="first_dept">
	                <option value="">## NONE ##</option>
                </select>
            </div>
             <div class="form-group">
              <select class="form-control dept" id="esecond_dept" name="second_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
              <div class="form-group">
              <select class="form-control dept" id="ethree_dept" name="three_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
              <div class="form-group">
              <select class="form-control dept" id="efour_dept" name="four_dept">
	                <option value="">## NONE ##</option>
                </select>
             </div>
            <div class="form-group ga_only">
                <label for="office_number">사무실전화번호</label>
                <input type="text" class="form-control" id="eoffice_number" name="office_number" maxlength="12">
            </div>
            <div class="form-group">
                <label for="seat">좌석</label>
                <div role="wrapper" class="gj-datepicker gj-datepicker-md gj-unselectable">
                <input type="text" class="form-control gj-textbox-md seat" id="eseat" name="seat" role="input">
                <i class="fa fa-map-marker seatMap" role="right-icon"></i>
                </div>    	
            </div>
            <div class="form-group">
                <label for="estatus">상태</label>
                <select class="form-control" id="estatus" name="status">
                	<option value="y">정상</option>
					<option value="n">휴직</option>
                </select>
            </div>
             <div class="form-group">
                <label for="profile">사진</label>
                <div role="wrapper" class="gj-datepicker gj-datepicker-md gj-unselectable">
                <input type="file" class="form-control gj-textbox-md" id="profile_upload" name="profile" role="input"/>
                <i class="fa fa-check upload"role="right-icon" style="display: none"></i>
                </div>
            </div>
            <div class="form-group" id="managerCr">
                <label for="">계정생성</label>
                <input type="checkbox" id="manager" name="manager" value="y">
            </div>
            <div class="form-group" id="managerDiv" style="display: none">
                <label for="managerAuth">계정권한</label>
                <select class="form-control" id="auth" name="auth">
                	<option value="0">일반</option>
					<option value="1">관리자</option>
                </select>
            </div>
            <button type="button" id="btnRevise" class="btn btn-default">Revise</button>
            <button type="button" id="btnCancel1" class="btn btn-default">Cancel</button>
        </form>
    </div>

</body>
</html>