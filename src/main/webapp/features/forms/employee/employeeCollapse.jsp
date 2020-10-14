<div style="margin: 10px">
    <h3>
            Employee forms
    </h3>
    <div class="accordion" id="accordionExample">
        <div class="card">
            <div class="card-header" id="headingOne">
                <h2 class="mb-0">
                    <button class="btn btn-outline-dark btn-block collapsed" type="button" data-toggle="collapse" data-target="#collapseOne"
                            aria-expanded="false" aria-controls="collapseOne">
                        Add request
                    </button>
                </h2>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                 data-parent="#accordionExample">
                <div class="card-body">
                    <%@ include file="placeHolidayRequest.jsp" %>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="headingTwo">
                <h2 class="mb-0">
                    <button class="btn btn-outline-dark btn-block collapsed" type="button" data-toggle="collapse"
                            data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Delete request
                    </button>
                </h2>
            </div>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                <div class="card-body">
                    <%@ include file="removeHolidayRequest.jsp" %>
                </div>
            </div>
        </div>
    </div>
</div>