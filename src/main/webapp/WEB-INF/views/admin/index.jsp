<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources/admin" var="cssroot" />
 

    <!-- /.content-header -->
	
    <!-- Main content -->


     	<div class="row"></div>
        <!-- Small boxes (Stat box) -->
        
        <div class="row mt-3">
       		<div class="card" style="width: 100%">
       			<div class="card-header">
       				<p class="card-title"> Trang chủ </p>
       			</div>
       			<div class="card-body" >
       				<div class="row">
       				   <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-info">
              <div class="inner">
                <h3>${totalAccount}</h3>

                <p>Total Account</p>
              </div>
              <div class="icon">
                <i class="ion ion-bag"></i>
              </div>
              <a href="/admin/users/getall" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
     
           <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-warning">
              <div class="inner">
                <h3>${totalRegister}</h3>

                <p>Service Registrations In Days</p>
              </div>
              <div class="icon">
                <i class="ion ion-person-add"></i>
              </div>
              <a href="/admin/service/register" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
               <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-success">
              <div class="inner">
                <h3><c:if test="${empty book }"> 0 </c:if>
                	<c:if test="${not empty book }"> ${book} </c:if>
                
                </h3>

                <p>Total Book In Month</p>
              </div>
              <div class="icon">
                <i class="ion ion-stats-bars"></i>
              </div>
              <a href="/admin/service/payment/getbill" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
          <!-- ./col -->
         
          <!-- ./col -->
          <div class="col-lg-3 col-6">
            <!-- small box -->
            <div class="small-box bg-danger">
              <div class="inner">
                <h3><c:if test="${empty totalFee }"> 0 </c:if>
                
                	<c:if test="${not empty totalFee }"> ${totalFee} </c:if>
                	</h3>

                <p>Total Fee In Month</p>
              </div>
              <div class="icon">
                <i class="ion ion-pie-graph"></i>
              </div>
              <a href="/admin/service/payment/getbill" class="small-box-footer">More info <i class="fas fa-arrow-circle-right"></i></a>
            </div>
          </div>
       				</div>
       				
       				<div class="row">
       				
       				<div id="chart1" style="min-width: 100%;  margin: 0 auto"></div>

       				</div>
       				
       			</div>
       		</div>
          <!-- ./col -->
        </div>
        <!-- /.row -->
        <!-- Main row -->
   
        <!-- /.row (main row) -->
      
  
    <!-- /.content -->
  <script>
  var data1 =  [<c:forEach var="book" items="${bookMonth}"> 
  				${book},
  			</c:forEach>];
  
    $(function () {
    	
    Highcharts.chart('chart1', {
        title: {
            text: 'Thống kê số lượt book trong năm',
        },
        xAxis: {
            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
        },
        yAxis: {
            title: {
                text: 'Book'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ' Book'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            data: data1
        }]
    });
    
});


  </script>