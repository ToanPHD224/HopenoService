<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources" var="cssroot" />
<c:url var="firstUrl" value="/admin/service/register?date=${currentdate}&pageNumber=1" />
<c:url var="lastUrl" value="/admin/service/register?date=${currentdate}&pageNumber=${totalPages}" />
<c:url var="prevUrl" value="/admin/service/register?date=${currentdate}&pageNumber=${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/service/register?date=${currentdate}&pageNumber=${currentPageNumber + 1}" /> 
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
				




				<div class="col-sm-12">
					
					<div class="row" style="width: 99%">
					
					<div class="col-sm-9">
						<div class="col-sm-6">
							<h3 class="card-title" >Registation</h3>
						</div>
						
					</div>
					<div class="col-sm-3">

						<input type="date" id="date" class="float-right form-control">

					</div>
					
					</div>
				
				</div>



				
				<div class="row">
					
						<div class="col-sm-12">
							<h1 class="card-title ml-2 mt-2">${message}</h1>
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
					<c:if test="${not empty listService}">
				<div class="row">

				
						<c:forEach var="x" items="${listService}">

							
								<form action="/admin/service/register" method="POST">

									<div class="card">
										<div class="card-body">
											<div class="row">
											<input type="hidden" value="${x.id}" name="id">
												<div class="col-sm-7">
													<img class="rounded" src="${cssroot}/image/admin/${x.image}" width="100%"
														height="100%" alt="">
												</div>
												<div class="col-sm-5">
													<div class="form-group">
														<label for="exampleInputEmail1">Email</label>
														<input type="email" class="form-control" name="mail"
															value="${x.mail}">
													</div>
													<div class="form-group">
														<label for="exampleInputEmail1">Address</label>
														<input type="text" class="form-control" name="address"
															value="${x.address}">
													</div>
													<div class="form-group">
														<label for="exampleInputEmail1">Name</label>
														<input type="text" class="form-control" name="name"
															value="${x.name}">
													</div>
													<div class="form-group">
														<label for="exampleInputEmail1">Districs</label>
														<input type="text"  value="${x.ward.districs.name}"
															class="form-control mb-2" />
													</div>
													<div class="form-group">
														<label for="exampleInputEmail1">Ward</label>
														<input type="text" value="${x.ward.name}"
															class="form-control mb-2" />
															<input type="hidden" value="${currentdate}" name="currentdate">
													</div>
													
												</div>
											</div>
										</div>
										<!-- /.card-body -->
										<div class="card-footer bg-transparent">
											<!-- ./col -->
											<div class="">
												<button style="border: 0.5px solid black;"  value=decline name="action" type="submit"
													class="btn btn-light float-right  ">
													Decline</i>
												</button>
												<button style="border: 0.5px solid black;"  value="accept" name="action" type="submit"
													class="btn btn-light float-right mr-1 ">Accept</button>



											</div>
										</div>
										<!-- /.row -->
									</div>
								</form>
							


						</c:forEach>
					
				</div>
				</c:if>
				
			</div>
			<div class="card-footer">
				<c:if test="${not empty listService}">
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-sm-center" id="pagination" >
						<c:choose>
				            <c:when test="${currentPageNumber == 1}">
				                <li class="disabled page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
				                <li class="disabled page-item"><a class="page-link" href="#">&lt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li class="page-item"><a class="page-link" href="${firstUrl}">&lt;&lt;</a></li>
				                <li class="page-item"><a class="page-link" href="${prevUrl}">&lt;</a></li>
				            </c:otherwise>
				        </c:choose>
				        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				            <c:url var="pageUrl" value="/admin/service/register?date=${currentdate}&pageNumber=${i}" />
				            <c:choose>
				                <c:when test="${i == currentPageNumber}">
				                    <li class="page-item active"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
				                </c:when>
				                <c:otherwise>
				                    <li class="page-item"><a class="page-link" href="${pageUrl}"><c:out value="${i}" /></a></li>
				                </c:otherwise>
				            </c:choose>
				        </c:forEach>
				        <c:choose>
				            <c:when test="${currentPageNumber == totalPages}">
				                <li class="disabled page-item"><a class="page-link" href="#">&gt;</a></li>
				                <li class="disabled page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li class="page-item"><a class="page-link" href="${nextUrl}">&gt;</a></li>
				                <li class="page-item"><a class="page-link" href="${lastUrl}">&gt;&gt;</a></li>
				            </c:otherwise>
				        </c:choose>

					</ul>
				</nav>
				</c:if>
				
			</div>
			<!-- /.card-body -->



		</div>
	</div>

	<!-- /.card-footer -->


</div>
<script>
	$("#date").change(function () {
		var xDate = $("#date").val();
		var url = "http://localhost:8090/admin/service/register?date=" + xDate + "&pageNumber=1";
		window.location.href = url;

	});
	
</script>