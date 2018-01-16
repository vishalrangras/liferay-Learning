<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@include file="/jsps/ihg/merlin/init.jsp"%>

<portlet:defineObjects />



	<c:choose>
		<c:when test="${fn:length(notificationList) gt 0}">
			<div class="merlin-notifications">
				<liferay-ui:journal-article showTitle="false" groupId="${groupId}"
					articleId="${topContentId}" />
				<div class="hotel-dets">
					<div class="hotel-dets-container">
						<c:forEach items="${notificationList}" var="notification">
							<div class="one-container">
								<div class="graybg">
									<div>
										<div class="left top">
											<label>Hotel Inn Code: </label> <span class="content">${notification.value.holidexCode}</span>
										</div>
										<div class="right top">
											<label> Hotel Name: </label> <span class="content">${notification.value.hotelName}</span>
										</div>
									</div>
								</div>
								<div>
									<div class="left">
										<label>Status: </label> <span>${notification.value.impacted}</span>
									</div>

								</div>
								<div class="cBoth">
									<div class="left">
										<label>Start Date: </label> <span>${notification.value.startDate}</span>
									</div>
									<div class="right">
										<label>End Date: </label> <span>${notification.value.endDate}</span>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- hotel dets container ends-->
				</div>
				<div class="bottom-content">
					<liferay-ui:journal-article showTitle="false" groupId="${groupId}"
						articleId="${bottomContentId}" />
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="merlin-notifications err-msg">
				<liferay-ui:journal-article showTitle="false" groupId="${groupId}"
					articleId="${noAccessContentId}" />
			</div>
		</c:otherwise>
	</c:choose>
