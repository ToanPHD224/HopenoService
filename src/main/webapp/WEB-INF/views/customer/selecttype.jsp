<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />
<main>
    <div class="section section-lg bg-soft mb-2">
        <div class="container">
            <div class="row pt-5 pt-md-0 ">

                <div class="card " style="width: 100%;" >
                    <div class="card-header text-center">
                        <h3 class="card-title"> Chọn môn thể thao bạn muốn chơi </h3>
                    </div>
                    <div class="card-body">
                        <div class="row justify-content-center" >
                        <c:forEach var="x" items="${listType}">
                            <div class="col-sm-4">
                                <div class="card bg-primary">
                                    <div class="card-header text-center">
                                    	<p>${x.name}</p>
                                    	
                                    </div>
                                    <div class="card-body ">
                                    
                                    	<a href="/customer/selecttype/${x.id}">       
                                    	                   	
                                    	<img  width="100%" style="height: 250px"  class="img-thumbnail" src="${cssroot}/image/admin/${x.image}">       
                                    	                       	
                                    	</a>
                                    
                                    </div>
                                </div>
                                <div class="card-footer">



                                </div>    

                            </div>
                            </c:forEach>
                        </div>

                    </div>

                </div>
                

            </div>
        </div>
    </div>
</main>