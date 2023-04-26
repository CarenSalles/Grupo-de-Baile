export default class MensajesPublicRepository {
    url = "http://localhost:8080/api/listemails";
  
    constructor() {}
  
    async getAll() {
      const response = await fetch(this.url);
      const json = await response.json();
  
      let messagesList = [];
  
      messagesList.push(json);
  
      return json;
    }
  }
  