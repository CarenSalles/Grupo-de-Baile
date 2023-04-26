<script setup>
import Pagination from "../components/gallery/Pagination.vue";
import { onBeforeMount, ref, computed } from "vue";
import ApiRepository from "../assets/ApiRepository/ApiRepository.js";
import { messages } from "../stores/messages";
import router from "../router/index";

const ourMessages = messages();

const repository = new ApiRepository("mensajes");
const api = repository.chooseApi();

const messagesCardxPage = 2;
const start = ref(0);

const end = computed(() =>
  Math.min(start.value + messagesCardxPage, ourMessagesList.value.length)
);

let ourMessagesList = ref([]);
onBeforeMount(async () => {
  ourMessagesList.value = await api.getAll();
});

const ourMessagesToShow = computed(() => {
  return ourMessagesList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += messagesCardxPage;
};

const prev = () => {
  start.value = Math.max(start.value - messagesCardxPage, 0);
};

const page = (algo) => {
  start.value = algo;
};

async function deletePost(id) {
  if (confirm("¿Está seguro de que quiere borrar este mensaje?") == true) {
    deleteThis(id);
  }
}

function consulting(id, mail) {
  ourMessages.messagesObject = mail;
  router.push("/modificarnuestroscorreos" + "/" + id);
}


async function deleteThis(id) {
  const response = fetch(`http://localhost:8080/api/listemails/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  }).then((response) => {
    if (response.status == 200) {
      alert("Mensaje borrado correctamente.");
    } else {
      alert(
        "Se ha producido un error. \nPor favor, inténtelo de nuevo en unos minutos."
      );
    }
  });
}
</script>
<template>
  <main>
    <div
      class="card mb-3"
      v-for="ourMessages in ourMessagesToShow"
      :key="ourMessages.id"
      :member="ourMessages"
    >
      <div class="row g-0">
        <div class="text">
          <div class="text-name">
            <p class="font-name">
              <b>{{ ourMessages.inputName }}</b>
            </p>
            <p class="font-name">
              <b>{{ ourMessages.inputPhone }}</b>
            </p>
            <p class="font-name">
              <b>{{ ourMessages.from }}</b>
            </p>
            <p class="font-name">
              <b>{{ ourMessages.subject }}</b>
            </p>
          </div>
        </div>
        <div class="options">
          <div class="text-date">
            <div class="card-body">
              <p class="btnsUser">
                <button
                  type="button"
                  class="btn btn-danger"
                  @click="deletePost(ourMessages.id)"
                >
                  Borrar
                </button>
                <button
                  type="button"
                  class="btn btn-success"
                  @click="
                    consulting(ourMessages.id, ourMessages)
                  "
                >
                  Consultar
                </button>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <Pagination
      :pageSize="messagesCardxPage"
      :start="start"
      :end="end"
      :maxLength="ourMessagesList.length"
      @change="page"
      @prev="prev"
      @next="next"
    />
  </main>
</template>

<style scoped lang="scss">
@import "../assets/sass/styles.scss";
@import "../assets/sass/galleryStyles/gallerystyles.scss";

main {
  padding-top: 5vw;
}
.row {
  width: 90%;
  max-width: none;
  margin: auto;
  background: #feffd7;
  display: flex;
  justify-content: space-between;
}

.row > * {
  max-width: none;
  width: auto;
}

img {
  aspect-ratio: 16/9;
  object-fit: cover;
  width: 200px;
}

.btn {
  margin: 0.3em;
  width: 5.4em;
}

.card-body {
  display: flex;
  justify-content: end;
  align-items: flex-end;
}
.text,
.text-date {
  padding: 10px;
}

.options {
  justify-self: end;
  align-self: self-end;
}

@media (max-width: 768px) {
  .row {
    flex-direction: column;

    img {
      width: 100%;
    }
    .options {
      justify-self: start;
      align-self: center;
    }
  }
}
.card {
  background-color: $background-component;
}
</style>
