
/**
 * 
 * @Author: Jay Patel
 * 
 * Description: All the JS functions of Merlin 2.1 Social Networking Portlet which can be included in the Footer after DOM is loaded.
 * 
 */

	

	
	function alignDatePicker() 
	{
		/*jQuery("#eventStartDate").datepicker({
	          showOn: 'button',
	          buttonImage: '/ME2-social-portlet/images/cal-icon.jpg',
	          buttonImageOnly: true,
	          dateFormat: 'mm/dd/yy',	              
	          buttonText: 'select date'     
	    });*/
		
		//initiate datepicker
		jQuery("#eventStartDate" ).datepicker({ dateFormat: 'mm/dd/yy' });
	}
 
	function adjustLikers()
	{
		jQuery('.taglib-ratings').addClass('thumbfloat');
	}
	
	/*function setBackGround()
	{
		jQuery("#content").attr("style", "background-color:#E9E9E9; border-bottom:1px solid #C2C2C2; border-left:1px solid #C2C2C2; border-right:1px solid #C2C2C2; padding-bottom:20px;");	
	}*/
	
	function modifyMessagePostEditor()
	{
		//jQuery('div#tabs_cont input:checkbox[name=memberBox]:checked').each(function(){
		
		// alert('modifyMessagePostEditor called...');	
		//jQuery('select[selectid=fontType]').remove();
		//jQuery('select[selectid=fontSize]').remove();
		//jQuery('span[class=lfr-separator]').remove();
		
		jQuery('select').each(function(){
			
			var attrValue = jQuery(this).attr("selectid");
			
			if(("fontType"==attrValue) || ("fontSize"==attrValue)){
				jQuery(this).remove();
			}
		});
		
		jQuery('span').each(function(){
			
			var attrValue = jQuery(this).attr("class");
			
			if("lfr-separator"==attrValue){
				jQuery(this).remove();
			}
		});
	}
	
	alignDatePicker();
	adjustLikers();
	/*setBackGround();*/
	modifyMessagePostEditor();
	
	