import { defineStore } from 'pinia'
import { ref } from 'vue';

export const messages = defineStore ('messages', () => {
	const messagesObject = ref([]);
	return messagesObject
})