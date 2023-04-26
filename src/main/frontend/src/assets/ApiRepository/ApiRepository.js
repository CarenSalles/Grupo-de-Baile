import QuienesSomosPublicRepository from "./xareuApi/QuienesSomosPublicRepository";
import EventosPublicRepository from "./xareuApi/EventosPublicRepository";
import SobreNosotrosPublicRepository from "./xareuApi/SobreNosotrosPublicRepository";
import NuestrosViajesPublicRepository from "./xareuApi/NuestrosViajesPublicRepository";
import MensajesPublicRepository from "./xareuApi/MensajesPublicRepository";

export default class ApiRepository {

    api;

    constructor(apiToCharge) {
        this.api = apiToCharge
        this.chooseApi()
    }

    chooseApi() {
        if(this.api === "quienesSomos") return new QuienesSomosPublicRepository;
        if(this.api === "eventos") return new EventosPublicRepository;
        if(this.api === "sobreNosotros") return new SobreNosotrosPublicRepository;
        if(this.api === "nuestrosviajes") return new NuestrosViajesPublicRepository;
        if(this.api === "mensajes") return new MensajesPublicRepository;
    }
}