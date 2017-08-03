[@ww.select 
label="buildConfigure"
       id="buildConfigure"   
       name="buildConfigure"
       list="listBuildConfigure"
       listKey="QMake Spec"
       listValue="name"
       multiple="false"
       size="3"
       required="true"
       value=2
/]

[@ww.textfield labelKey="qmakeSpec" name="qmakeSpec" required='true'/]

[@ww.textfield labelKey="aditionalArgs" name="aditionalArgs" required='true'/]

<script>
function myFunction()
{
  var deployType=document.getElementById("buildConfigure");
  alert("buildConfigure = " + buildConfigure.value);

}
</script>