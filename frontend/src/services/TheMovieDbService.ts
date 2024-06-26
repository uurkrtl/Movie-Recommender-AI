import axios from "axios";

export default class TheMovieDbService {
    getMovieGenres() {
        return axios.get('api/themoviedb/get-genres')
    }
}