<template>
   <div>
    <h1>  Class 바인딩</h1>
    <div style="color:red">클래스 바인딩1</div>
    <div class="text-red">클래스 바인딩2</div>
    <!-- 선택자 명이 두개의 단어로 구성되어 있으면, ' 기호 생략시 에러 <div :class="{text-red: ture}"> -->
    <div :class="{'text-red': true}">클래스 바인딩3</div>
    <div :class="{'text-red': false}">클래스 바인딩4</div>
    <div :class="{'text-red': true, active:true}">클래스 바인딩5</div>
    <div :class="{'text-red': false, 'active':true}">클래스 바인딩6</div>
    <div :class="{'text-red': hasError, 'active':isActive}">클래스 바인딩7</div>

<!-- class를 배열로 저장후 적용, 실무에서 그렇게 많이 사용하지 않음 -->
  <div :class="class2">클래스 바인딩8</div>

   </div>
</template>

<script>
// eslint-disable-next-line
export default {
  data() {
    return {
      hasError: false,
      isActive: true,
      class2: ['active', 'text-red']
    }
  }
}
</script>

<style scoped>
/* 현재 문서에서만 스타일 적용 */
 .text-red{ color: red;}
 .active {background-color: greenyellow; font-weight: bold;}
</style>
