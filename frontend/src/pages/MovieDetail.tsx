import MovieService from "../services/MovieService.ts";
import {Link, useNavigate, useParams} from "react-router-dom";
import {Movie} from "../types/Movie.ts";
import {useEffect, useState} from "react";

const movieService = new MovieService();

function MovieDetail() {
    const { id = '' } = useParams<string>();
    const { queryId = '' } = useParams<string>();
    const [movie, setMovie] = useState<Movie>({
        id: id,
        movieName: '',
        movieNameGerman: '',
        imdbRating: 0,
        headliner: '',
        releaseYear: 0,
        posterPath: '',
        overview: '',
        themoviedbId: '',
        createdAt: new Date(),
        updatedAt: new Date()
    });
    const [loading, setLoading] = useState(true);
    const navigate = useNavigate();
    const basePosterUrl = 'https://image.tmdb.org/t/p/original';

    useEffect(() => {
        if (id) {
            movieService.getMovieByMovieId(id)
                .then((response) => {
                    setMovie(response.data);
                    setLoading(false);
                })
                .catch((error) => {
                    console.error('Error fetching product:', error);
                    navigate('*');
                });
        }
    }, [id, navigate]);

    if (loading) {
        return <div className={'container'}>
            <div className={'spinner-border text-primary'}>
                <span className={'visually-hidden'}></span>
            </div>
            <h5>Wird geledan...</h5>
        </div>;
    }

    return (
        <div className="container">
            <div className="row flex-lg-row-reverse align-items-center g-5 py-4">
                <div className="col-10 col-sm-8 col-lg-6">
                    <img src={`${basePosterUrl}${movie.posterPath}`} className="d-block mx-lg-auto img-fluid" alt="Product"
                         width="400" height="300" loading="lazy"/>
                </div>
                <div className="col-lg-6">
                    <h1 className="display-5 fw-bold text-body-emphasis lh-1 mb-3">{movie.movieNameGerman}</h1>

                    <table className="table table-striped-columns">
                        <tbody>
                            <tr>
                                <th scope="row">Originalname</th>
                                <td>{movie.movieName}</td>
                            </tr>
                            <tr>
                                <th scope="row">Hauptdarsteller</th>
                                <td>{movie.headliner}</td>
                            </tr>
                            <tr>
                                <th scope="row">Erscheinungsjahr</th>
                                <td>{movie.releaseYear}</td>
                            </tr>
                            <tr>
                                <th scope="row">IMDB Bewertung</th>
                                <td>{movie.imdbRating}</td>
                            </tr>
                        </tbody>
                    </table>
                    <p className="lead">{movie.overview}</p>

                    <div className="d-grid gap-2 d-md-flex justify-content-md-start">
                        <Link to={`/movies/${queryId}`} type="button"
                              className="btn btn-primary btn-lg px-4 me-md-2">Zurück zu meinen Filmen</Link>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default MovieDetail;