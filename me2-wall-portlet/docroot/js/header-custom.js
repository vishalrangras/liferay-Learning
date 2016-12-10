
/**
 * 
 * @Author: Jay Patel
 * 
 * Description: All the JS functions of Merlin 2.1 Social Networking Portlet which can be included in the Header before DOM is loaded.
 * 
 */


	/**
	 * Get Ids of Category, Thread & Root Message
	 */
	function getCategoryThreadDetails(tdButtonObj, catId, threadId, rootMessageId)
	{	
		
		// var categoryThreadParentMessageId = jQuery(tdButtonObj).parent().parent().parent().parent().attr('id');
		
		var categoryThreadParentMessageId = catId + "~" + threadId + "~" + rootMessageId;
		// alert("categoryThreadParentMessageId: " + categoryThreadParentMessageId);
		jQuery('#categoryThreadParentMessageId').val(categoryThreadParentMessageId);
		
		var myCommentsObj = jQuery(tdButtonObj).parent().find("input[type=text][name=myComments]");

		if(myCommentsObj != null){
			var comments = jQuery(myCommentsObj).val();
			// alert("comments: " + comments);
			jQuery('#hiddenComments').val(comments);	
		}else{
			alert("Please enter proper comments before Posting!");
		}
		
		return true;
	}

	/**
	 * 
	 * @param tdButtonObj
	 * @return
	 */
	function postReply(tdButtonObj, portletNamespace, postReplyURL, catId, threadId, rootMessageId)
	{
		if(getCategoryThreadDetails(tdButtonObj, catId, threadId, rootMessageId))
		{
			var wallPostsFormName = portletNamespace + 'wallPosts';
			var formObj = document.getElementById(wallPostsFormName);
			if(formObj != null)
			{
				formObj.action = postReplyURL;
				formObj.submit();
			}else{
				// alert("Post Reply Form not Found");
			}
			return true;
		}
	}

	
	/**
	 * 
	 * @param portletNamespace
	 * @param deleteURL
	 * @param threadId
	 * @return
	 */
	function deleteThread(portletNamespace, deleteURL, threadId)
	{
		
		if(portletNamespace != null && deleteURL != null && threadId != null)
		{
			var wallPostsFormName = portletNamespace + 'wallPosts';
			var formObj = document.getElementById(wallPostsFormName);
			deleteURL += "&threadId=" + threadId;
			
			if(formObj != null)
			{
				formObj.action = deleteURL;
				formObj.submit();
			}else{
				// alert("Post Reply Form not Found");
			}
		}
		
		return false;
	}
	
	/**
	 * Used to hide all the Dislike(Thumb-Down) Images of Message Ratings
	 */
	function hideRatingsDislikes()
	{
		jQuery('a.aui-rating-element.aui-rating-element-off.aui-rating-thumb-down').attr("style", "display:none");
	}	

	
	
	

	/**
	 * 
	 * @param showLikersURL
	 * @param messageId
	 * @return
	 * 
	 * Used to open a Pop-Up for all the Likers of particular Thread
	 */
	/*function displayLikers(showLikersURL, messageId)
	{
		showLikersURL += "&messageId=" + messageId + "&myAction=showAllLikers";

		Liferay.IHG.displayPopup(showLikersURL, "Here are all the Likers!!!");
	}*/
	
	
	/**
	 * 
	 * @param showUserProfileURL
	 * @param userId
	 * @return
	 * 
	 * Used to open a Pop-Up to display particular User Information
	 */
	/*function showUserProfile(showUserProfileURL, userId)
	{
		showUserProfileURL += "&userId=" + userId + "&myAction=showUserProfile";

		Liferay.IHG.displayPopup(showUserProfileURL, "User Profile");
	}*/
	
	
		
	