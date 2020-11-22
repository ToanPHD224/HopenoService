<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<c:url value="/resources" var="cssroot" />
        <div class="row">
            <div class="content-header">
				<div class="container-fluid">
				  <div class="row mb-2">
				
					  <h1 class="m-0 text-light">Service Type</h1>
					<!-- /.col -->
				 <!-- /.col -->
				  </div><!-- /.row -->
				</div><!-- /.container-fluid -->
			  </div>
            <div class="card">
                <div class="card-header">                  
                        <button style="border: none;" class="btn  btn-primary "><i class="fas fa-plus"></i>  </button>
                
                </div>
                <div class="card-body">
                    <div class="row">

                        <div class="col-sm-4">
                            <div class="card card-success">
                                <div class="card-header">
                                    <h3 class="card-title">FootBall</h3>
                                    <div class="float-right">
                                        <button style="border: none; opacity: 0.7;" class="btn-dark" data-toggle="modal"
                                            data-target="#modalPoll-1"> <i class="fas fa-wrench"></i> </button>
                                        <button style="border: none; opacity: 0.7;" class="btn-dark"> <i
                                                class="fa fa-trash"></i> </button>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                            
                                    <div class="row">
                                        <img style="height: 250px;" src="${cssroot}/image/bongda.jpg" width="100%"
                                            class="img-thumbnail" alt="">
                                    </div>

                                    <hr>

                                    <strong><i class="fas fa-pencil-alt mr-1"></i> Fee booking</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger"> 0.01 for onetime </span>

                                    </p>
                                    <hr>

                                    <strong><i class="fas fa-shield-alt"></i> Satus</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger">Enable</span>

                                    </p>
                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card card-success">
                                <div class="card-header">
                                    <h3 class="card-title">Badminton</h3>
                                    <div class="float-right">
                                        <button class="btn-secondary"> <i class="fas fa-wrench"></i> </button>
                                        <button class="btn-secondary"> <i class="fa fa-trash"></i> </button>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">

                                    <img style="height: 250px;" src="${cssroot}/image/caulong.png" width="100%"
                                        height="50%" class="img-thumbnail" alt="">

                                    <hr>

                                    <strong><i class="fas fa-pencil-alt mr-1"></i> Fee booking</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger">4% for one time</span>

                                    </p>
                                    <hr>

                                    <strong><i class="fas fa-shield-alt"></i></i> Satus</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger">Enable</span>

                                    </p>



                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="card card-success">
                                <div class="card-header">
                                    <h3 class="card-title">Basketball</h3>
                                    <div class="float-right">
                                        <button class="btn-secondary"> <i class="fas fa-wrench"></i> </button>
                                        <button class="btn-secondary"> <i class="fa fa-trash"></i> </button>
                                    </div>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">

                                    <img style="height: 250px;" src="${cssroot}/image/bongro.jpg" width="100%"
                                        height="100px" class="img-thumbnail" alt="">

                                    <hr>

                                    <strong><i class="fas fa-pencil-alt mr-1"></i> Fee booking</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger">5% For one Time</span>

                                    </p>
                                    <hr>

                                    <strong><i class="fas fa-shield-alt"></i>Satus</strong>

                                    <p class="text-muted">
                                        <span class="tag tag-danger">Enable</span>

                                    </p>


                                </div>
                                <!-- /.card-body -->
                            </div>
                        </div>

                    </div>
                </div>

            </div>
            

        </div>
    
<script>
    $.ajax({
        url: 'http://localhost:8090/admin/delete/',
        type: 'DELETE',
        success: function (result) {
            alert("thanh cong");
        }
    });
</script>