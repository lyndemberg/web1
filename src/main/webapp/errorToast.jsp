<script>
    var status = ${pageContext.response.status};
    var error = "${pageContext.response.getHeader("errorMessage")}";
    if(status == 400){
        M.toast({html: error });
    }
</script>
