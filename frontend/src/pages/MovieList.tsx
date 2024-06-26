import {Link, useParams} from "react-router-dom";
import MovieQueryService from "../services/MovieQueryService.ts";
import {useEffect, useState} from "react";
import {Movie} from "../types/Movie.ts";

const movieQueryService = new MovieQueryService();

function MovieList() {
    const [movies, setMovies] = useState<Movie[]>([]);
    const [loading, setLoading] = useState(true);
    const { queryId = '' } = useParams<string>();
    const [errorMessage, setErrorMessage] = useState<string>('');
    const basePosterUrl = 'https://image.tmdb.org/t/p/original';

    const truncateText = (text: string, maxLength: number) => {
        if (text.length > maxLength) {
            return text.substring(0, maxLength - 3) + '...';
        }
        return text;
    };

    useEffect(() => {
            movieQueryService.getMoviesByQueryId(queryId).then((response) => {
                setMovies(response.data);
                setLoading(false);
            }).catch(error => {
                setErrorMessage(`Error retrieving movies: ${error.message}`);
                setLoading(false);
            });
    }, [queryId]);

    if (loading) {
        return <div className={'container'}>
            <div className={'spinner-border text-primary'}>
                <span className={'visually-hidden'}></span>
            </div>
            <h5>Wird geledan...</h5>
        </div>;
    }

    return (
        <div className="container mt-5">
            <div className="row py-4 mb-2">
                {
                    movies.map((movie) => {
                        return (
                                <div className="col-md-12" key={movie.id}>
                                    <div
                                        className="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                                        <div className="col-auto d-none d-lg-block">
                                            <img className="bd-placeholder-img"
                                                 src={`${basePosterUrl}${movie.posterPath}`}
                                                 alt="Movie Poster" width="130" height="180" autoFocus={false}/>
                                        </div>
                                        <div className="col p-4 d-flex flex-column position-static">
                                            <h5 className="mb-0"><strong style={{marginRight: '5px'}}>{movie.movieNameGerman}</strong>({movie.movieName})</h5>
                                            <div
                                                className="mb-1 text-body-secondary">{movie.releaseYear} | {movie.imdbRating}</div>
                                            <p className="card-text mb-auto">{truncateText(movie.overview, 210)}</p>
                                            <Link to={`/movie-detail/${movie.id}/${queryId}`} className="icon-link gap-1 icon-link-hover stretched-link">
                                                Detail
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                     fill="currentColor" className="bi bi-chevron-double-right"
                                                     viewBox="0 0 16 16">
                                                    <path fillRule="evenodd"
                                                          d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708"/>
                                                    <path fillRule="evenodd"
                                                          d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708"/>
                                                </svg>
                                            </Link>
                                        </div>
                                    </div>
                                </div>
                        )

                    })
                }

            </div>
            {errorMessage && (
                <div className="alert alert-danger" role="alert">
                    {errorMessage}
                </div>
            )}
        </div>
    );
}

export default MovieList;