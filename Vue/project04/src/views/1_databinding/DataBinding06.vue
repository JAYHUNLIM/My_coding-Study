<template>
   <div>
    <h1> Radio 바인딩</h1>
    <div>
      <input type="radio" id="html" value="html" v-model="favlang">
      <label for="html">HTML</label>
    </div>
    <div>
      <input type="radio" id="css" value="css" v-model="favlang">
      <label for="css">CSS</label>
    </div>
    <div>
      <input type="radio" id="js" value="js" v-model="favlang">
      <label for="js">JS</label>
    </div>
     <div>
      선택한 과목 : {{ favlang }}
     </div>
   </div>
</template>

<script>
export default {
  data() {
    return {
      favlang: ' '
    }
  }
}
/* eslint-disable */
//radio속성은 하나만 선택되기 때무넹 문자열로 취급한다
</script>
