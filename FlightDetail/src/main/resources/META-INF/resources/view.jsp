<%@ include file="/init.jsp" %>


<div class="flightDetails">
	<div class="flightStatusContainer">
		<div class="homeArrivalFlight">
			<c:if test="${fn:length(flightDetailList) gt 0}">
				<div class="dataHeading">
				    <span class="time">Time</span>
				    <span class="flightNumber">Flight No.</span>
				    <span class="terminal">Terminal</span>
				    <span class="expectTime">Status</span>
			   </div>
				<c:forEach var="flightDetail" items="${flightDetailList}">
					<div class="data">
						<a href="#">
							<span class="time">${flightDetail.arrivalTime}</span>
							<span class="flightNumber">${flightDetail.flightId}</span>
							<span class="terminal">${flightDetail.arrivalTerminal}</span>
							<span class="expectTime">${flightDetail.liveStatus}</span>
							 <span class="arrow whiteimg"></span>
							
						</a>
						 
						
					</div>
				</c:forEach>
			</c:if>
			
			
			
			
		</div>
	</div>

</div>