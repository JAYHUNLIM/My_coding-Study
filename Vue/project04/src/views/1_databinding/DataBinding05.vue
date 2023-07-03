<template>
   <div>
    <h1> CheckBox 바인딩</h1>
    <div>
      <input type="checkbox" id="html" value="html" v-model="favlang">
      <label for="html">HTML</label>
    </div>
    <div>
      <input type="checkbox" id="css" value="css" v-model="favlang">
      <label for="css">CSS</label>
    </div>
    <div>
      <input type="checkbox" id="js" value="js" v-model="favlang">
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
      favlang: ['js']
    }
  }
}
/* eslint-disable */
//radio속성은 하나만 선택되기 때무넹 문자열로 취급한다
// favoriteLang: [] // 여러개 선택이 가능한 값은 반드시 배열로 선언한다
</script>
