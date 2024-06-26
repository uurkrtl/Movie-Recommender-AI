import React, {useEffect, useState} from "react";
import {OpenAiMovieRequest} from "../types/OpenAiMovieRequest.ts";
import {useNavigate} from "react-router-dom";
import MovieService from "../services/MovieService.ts";
import {Genre} from "../types/Genre.ts";
import TheMovieDbService from "../services/TheMovieDbService.ts";


function Homepage() {
    const movieService = new MovieService();
    const theMovieDbService = new TheMovieDbService();
    const [openAiMovieRequest, setOpenAiMovieRequest] = useState<OpenAiMovieRequest>({
        genre: '',
        actorDirector: '',
        moodTheme: '',
        minRating: 0,
        specialInterest: ''
    });
    const [errorMessage, setErrorMessage] = useState<string>('');
    const navigate = useNavigate();
    const [isDisabled, setIsDisabled] = useState(false);
    const [genres, setGenres] = useState<Genre[]>([]);

    useEffect(() => {
        theMovieDbService.getMovieGenres().then((response) => {
            setGenres(response.data);
        });
    });

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setIsDisabled(true)
        movieService.generateAndSaveMovieList(openAiMovieRequest).then(response => {
            navigate(`/movies/${response.data}`)
            setErrorMessage('')
        }).catch(error => {
            if (error.response) {
                setErrorMessage(error.response.data.message);
            }else {
                setErrorMessage('Etwas ist schief gelaufen: ' + error.message);
            }
        });
    }

    return (
        <main className={'container'}>
                <div className="py-5 text-center">
                    <img className="d-block mx-auto mb-2" src="https://i.ibb.co/PZTxpLB/logo-navbar.png" alt="" width="100" height="100"/>
                    <h2>Filmempfehlungen</h2>
                    <p>
                        Nenne mir deine Vorlieben, und ich werde dir Filme empfehlen.
                    </p>
                </div>

                <div className="row g-5">
                    <div className="col-md-7 col-lg-12">
                        <h4 className="mb-3">Meine Vorlieben</h4>
                        <form onSubmit={handleSubmit}>
                            <div className="row g-3">

                                <div className="col-sm-3">
                                    <div className="input-group">
                                        <span className="input-group-text" id="inputGroup-sizing-default">Genre</span>
                                        <select className="form-select" id="state" defaultValue="Action"
                                                onChange={(e) => setOpenAiMovieRequest(
                                                    {...openAiMovieRequest, genre: e.target.value})}>
                                            {genres.map((genre) => {
                                                return (
                                                    <option key={genre.id}
                                                            value={genre.name}>{genre.name}</option>
                                                )
                                            })};
                                        </select>
                                    </div>
                                </div>

                                <div className="col-sm-5">
                                    <div className="input-group">
                                        <span className="input-group-text" id="inputGroup-sizing-default">Schauspieler oder Regisseur</span>
                                        <input type="text" className="form-control" id="actorDirector" value={openAiMovieRequest.actorDirector}
                                        onChange={(e) => setOpenAiMovieRequest(
                                            {...openAiMovieRequest, actorDirector: e.target.value})}/>
                                    </div>
                                </div>

                                <div className="col-sm-4">
                                    <div className="input-group">
                                        <span className="input-group-text"
                                              id="inputGroup-sizing-default">Stimmungsthema</span>
                                        <input type="text" className="form-control" id="moodTheme" value={openAiMovieRequest.moodTheme}
                                               onChange={(e) => setOpenAiMovieRequest(
                                                   {...openAiMovieRequest, moodTheme: e.target.value})}/>
                                    </div>
                                </div>

                                <div className="col-sm-3">
                                    <div className="input-group">
                                        <span className="input-group-text"
                                              id="inputGroup-sizing-default">Mindestbewertungspunktzahl</span>
                                        <input type="number" step="0.1" className="form-control" id="minRating"
                                               value={openAiMovieRequest.minRating}
                                               onChange={(e) => setOpenAiMovieRequest(
                                                   {...openAiMovieRequest, minRating: parseFloat(e.target.value)
                                               })}/>
                                    </div>
                                </div>

                                <div className="col-sm-9">
                                    <div className="input-group">
                                        <span className="input-group-text"
                                              id="inputGroup-sizing-default">Besonderes Interesse</span>
                                        <input type="text" className="form-control" id="specialInterest"
                                               onChange={(e) => setOpenAiMovieRequest(
                                                   {...openAiMovieRequest, specialInterest: e.target.value})}/>
                                    </div>
                                </div>

                            </div>

                            <button className="w-100 btn btn-primary btn-lg mt-3 mb-3" type="submit" disabled={isDisabled}>
                                {isDisabled ? 'Deine Filmliste kommt...' : 'Was soll ich mir heute ansehen?'}</button>
                        </form>
                        {errorMessage && (
                            <div className="alert alert-danger" role="alert">
                                {errorMessage}
                            </div>
                        )}
                    </div>
                </div>
            </main>
    );
}

export default Homepage;