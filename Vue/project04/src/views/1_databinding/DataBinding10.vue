<template>
   <div>
    <h1> Style 속성 바인딩</h1>
    <div style="color:red; font-size: 20px">스타일 바인딩:글씨 red,폰트크기:20px</div>
   <div :style="style1"> 스타일바인딩: 글씨 green, 폰트크기:30px</div>
   <button @click="style1.color='blue'">색상바꾸기</button>
   </div>
</template>

<script>
export default {
  data() {
    return {
      style1: { color: 'green', fontSize: '30px' }
    }
  }
}
</script>
