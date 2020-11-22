<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />

<div class="row">

	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">


				<!-- /.col -->
				<!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.container-fluid -->
	</div>
	<div class="col-sm-12">
		<div class="card img-thumbnail ">


			<div class="card-header">
				<div class="row">





					<div class="col-sm-9">
						<h1>Registation</h1>
					</div>
					<div class="col-sm-3">

						<input type="date" id="date" class="float-right form-control">

					</div>



				</div>
			</div>
			<!-- /.card-header -->
			<!-- form start -->

			<div class="card-body font-italic">
				<c:if test="${empty listService}">
					<div class="row">

						<div class="col-sm-12">

							<div>

								<p class="card-title "> Not bill on today </p>

							</div>

						</div>

					</div>
				</c:if>
				<div class="row">

					<c:if test="${not empty listService}">
						<c:forEach var="x" items="${listService}">

							<div class="col-sm-6">
								<form action="" method="post">

									<div class="card">
										<div class="card-body">
											<div class="row">
												<div class="col-sm-7">
													<img class="rounded" src="${cssroot}/image/${x.image}"
														width="100%" height="100%" alt="">


												</div>
												<div class="col-sm-5">
												  <div class="form-group">
												    <label for="exampleInputEmail1">Email address</label>
												    <input type="email" class="form-control" id="exampleInputEmail1"  value="${x.mail}">
												
												  </div>
												  <div class="form-group">
												    <label for="exampleInputEmail1">Name</label>
												    <input type="text" class="form-control" id="name"  value="${x.name}">
												  </div>
												  <div class="form-group">
												    <label for="exampleInputEmail1">Ward</label>
													<input type="text" id="mail" value="${x.ward.name}"
													class="form-control mb-2" />
												  </div>
												  <div class="form-group">
												    <label for="exampleInputEmail1">Districs</label>
													<input type="text" id="mail" value="${x.ward.districs.name}"
													class="form-control mb-2" />
												  </div>
														
													
													

												</div>

											</div>



										</div>
										<!-- /.card-body -->
										<div class="card-footer bg-transparent">
											<!-- ./col -->
											<div class="">
												<button style="border: 0.5px solid black;" type="submit"
													class="btn btn-light float-right  ">
													Decline</i>
												</button>
												<button style="border: 0.5px solid black;" type="submit"
													class="btn btn-light float-right mr-1 ">Accept</button>



											</div>
										</div>
										<!-- /.row -->
									</div>
								</form>
							</div>


						</c:forEach>
					</c:if>
				</div>

			</div>
			<div class="card-footer">
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-sm-center">
					  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
					  <li class="page-item"><a class="page-link" href="#">1</a></li>
					  <li class="page-item"><a class="page-link" href="#">2</a></li>
					  <li class="page-item"><a class="page-link" href="#">3</a></li>
					  <li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				  </nav>
			</div>
			<!-- /.card-body -->



		</div>
	</div>

	<!-- /.card-footer -->


</div>
<script>
	$("#date").change(function () {
		var xDate = $("#date").val();
		var url = "http://localhost:8090/admin/registerform?date=" + xDate +"&pageNumber=1";
		window.location.href = url;

	});

</script>