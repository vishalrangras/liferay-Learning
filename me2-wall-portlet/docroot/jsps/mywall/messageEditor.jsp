<liferay-ui:input-editor toolbarSet="slimmed" width="550" height="180"/>
<input name="myThreadBody" type="hidden" value="" id="myThreadBody" />

<script type="text/javascript">
function <portlet:namespace />initEditor() {
	jQuery(".cke_contents").css("height", "80px");
	return "(Type Your Message Here)";
}
</script>
