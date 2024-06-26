import {Route, Routes} from "react-router-dom";
import Homepage from "../pages/Homepage.tsx";
import MovieList from "../pages/MovieList.tsx";
import MovieDetail from "../pages/MovieDetail.tsx";

function Dashboard() {
    return (
        <div className="mt-5">
            <Routes>
                <Route path={'/'} element={<Homepage/>}/>
                <Route path={'/movies/:queryId'} element={<MovieList/>}/>
                <Route path={'/movie-detail/:id/:queryId'} element={<MovieDetail/>}/>
            </Routes>
        </div>

    );
}

export default Dashboard;