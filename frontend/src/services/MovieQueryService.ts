import axios from "axios";

export default class MovieQueryService {
    getMoviesByQueryId(queryId: string) {
        return axios.get(`/api/movie-queries/${queryId}`);
    }
}