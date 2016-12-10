package com.ihg.me2.portlet.constants;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;


/**
 * 
 * @author Jay Patel
 * 
 * Main Constant File for the Merlin 2.1 Wall Portlet
 *
 */

public interface WallConstants 
{

		/**
		 * Wall
		 * 
		 */

		public static final String VIEW_MYWALL_POSTS = "mywall/myWall";
		public static final String VIEW_SHOW_LIKERS = "mywall/showLikers";
		public static final String VIEW_SHOW_USER_PROFILE = "mywall/userProfile";
		public static final String VIEW_PREFERENCES = "mywall/edit";
		
		public static final String DEFAULT_MESSAGE_BOARDS_THREAD_VIEW = PropsUtil.get(PropsKeys.MESSAGE_BOARDS_THREAD_VIEWS_DEFAULT);
		public static final String PARAM_MESSAGE_BOARDS_DISPLAY_LIST = "messageBoardsDisplayList"; 
		public static final String PARAM_CATEGORY_ID_NAME_MAP = "categoryIdNameMap";
		public static final String SUBJECT_THREAD = "THREAD SUB : ";
		public static final String SUBJECT_MESSAGE = "RE: ";
		public static final String THREAD_TYPE_EVENT = "Event";
		
		public static final String SEND_EMAIL_DEFAULT = "yes";
		public static final String SEND_EMAIL_YES = "yes";
		public static final String SEND_EMAIL_NO = "no";
		
		public static final long DEFAULT_USER_ID = 0;
		public static final int MAX_DELTA_SIZE_THREAD = 20;
		public static final int DEFAULT_MESSAGE_BOARD_CATEGORY_ID = 0;

		public static final long NEW_THREAD_THREADID = 0;
		public static final long NEW_THREAD_PARENT_MESSAGE_ID = 0;
		
		public static final Boolean IS_ANONYMUS = Boolean.FALSE;
		public static final Boolean DEFAULT_ALLOW_PINGBACKS = Boolean.TRUE;
		
		public static final int DEFAULT_EMAIL_CONTENT_TRIM_INDEX = 30;
		
		public static final List<ObjectValuePair<String, InputStream>> DEFAULT_FILES = new ArrayList<ObjectValuePair<String, InputStream>>();
		
		public static final double DEFAULT_PRIORITY = 1.0;
		
		public static final String DEFAULT_ATTACHMENT_VIEW = "null";
		
		public static final String ATTRIBUTE_FORWARD_PATH = "FORWARD_PATH";
		
		public static final int DEFAULT_DELTA_START_COUNT = 0;
		
		public static final Boolean INCLUDE_PREV_NEXT = Boolean.TRUE;
		
		public static final String MESSAGE_POST_DATE_FORMAT = "M/d/yy h:mm a"; /*"yyyyMMddHHmm";*/
		
		public static final String MESSAGE_POST_DATE_WITH_TIMEZONE_FORMAT = "M/d/yy h:mm a z";
		
		public static final String MEETING_POINT_FORUM_ADMIN_ROLE = "MEETING-POINT-FORUM-ADMIN";
		
		public static final String MEETING_POINT_FORUM_USER_ROLE = "MEETING-POINT-FORUM-USER";
		
		public static final String MEETING_POINT_FORUM_DEFAULT_CATEGORY = "MEETING-POINT-DEFAULT-CATEGORY";
}
