<template>
   <div>
    <h1>다양한 속성 바인딩</h1>
  <hr>
  <h3>readonly 속성</h3>
  <!-- readonly 속성에서  v-model이면 양방향이 될수 있음 -->
  <input type="text" name="" id="" readonly v-model="userid">
  <!--value 속성에 단방향 데이터 바인딩할수 있다  -->
  <input type="text" name="" id="" v-bind:value="userid" readonly>
  <!-- v bind 생략 -->
  <input type="text" name="" id="" :value="userid" readonly>
  <hr>
  <h3>src 속성</h3>
  <!-- 이미지 속성도 데이터 바인딩 할 수 있 다 -->
  <img :src="imgSrc" alt="" style="width: 100px; height: auto;">
  <hr>
  <h3>disable 속성-검색어를 입력하지 않으면 조회버튼 비활성화</h3>
  <input type="search" name="" id="" v-model="txt1">
  <button :disabled="txt1 === ''">조회</button>
</div>
</template>

<script>
/*eslint-disable*/
export default {
  data() {
    return {
      userid: 'korea',
      imgSrc: 'https://www.itwill.co.kr/css/wvtex/img/wvUser/logo.png',
      txt1: ''
    }
  }
}
</script>
