<script setup>
import { computed } from "@vue/reactivity";
import { messages } from "../../stores/messages";

const mailToModify = messages();
const mailData = computed(() => {
  return mailToModify.messagesObject;
});

</script>

<template>
  <form>
    <div class="container mt-2">
      <div class="col-12 col-md-8">
        <h2 class="mt-2">Mensaje de  {{ mailData.inputName }}</h2>
        <div class="mb-3">
        </div>
        <h3>{{ mailData.inputName }}</h3>
        <p>Teléfono: {{ mailData.inputPhone }}</p>
        <p>Email: {{ mailData.from }}</p>
        <p>Asunto: {{ mailData.subject }}</p>
        <p>Mensaje: {{ mailData.message }}</p>
        <div class="mb-3">
        </div>

        <div class="mb-3">
        </div>
      </div>
      <div class="d-flex mb-3 mt-3">
      </div>
    </div>
  </form>
</template>

<style lang="scss" scoped>
@import "../../assets/sass/variables";

h2 {
  font-family: $font-text;
  text-align: center;
}

.container {
  width: 80%;
  max-width: none;
  margin: 0 auto;
  display: flex;
  justify-content: space-around;
  align-items: center;
  flex-direction: column;
  background-color: $background-component;
  height: 100%;
}

.form-control {
  width: 100%;
  border-radius: 10px;
}

.label {
  font-family: $font-text;
}

input {
  width: 100%;
  background-color: #ffffff;
}

.btn {
  width: 100%;
}

textarea {
  height: 250px;
}

@media (min-width: 768px) {
  .w-10 {
    width: 10%;
  }
}
</style>
