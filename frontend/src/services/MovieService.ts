import {OpenAiMovieRequest} from "../types/OpenAiMovieRequest.ts";
import axios from "axios";

export default class MovieService {
    generateAndSaveMovieList(openAiMovieRequest: OpenAiMovieRequest) {
        return axios.post('/api/movies/generate', openAiMovieRequest)
    }

    getMovieByMovieId(id: string) {
        return axios.get(`/api/movies/${id}`)
    }
}