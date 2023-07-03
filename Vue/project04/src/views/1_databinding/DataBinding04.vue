<template>
   <div>
    <h3>select 바인딩</h3>
    <select name="" id="" v-model="selectedCity">
      <option value=""></option>
      <option value="02">서울</option>
      <option value="054">제주</option>
      <option value="064">부산</option>
    </select>
   </div>
</template>

<script>
export default {
  data() {
    return {
      selectedCity: '02'
    }
  }
}
</script>
