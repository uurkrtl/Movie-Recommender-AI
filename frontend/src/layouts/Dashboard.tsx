import {Route, Routes} from "react-router-dom";
import Homepage from "../pages/Homepage.tsx";
import MovieList from "../pages/MovieList.tsx";

function Dashboard() {
    return (
        <div className="mt-5">
            <Routes>
                <Route path={'/'} element={<Homepage/>}/>
                <Route path={'/movies/:queryId'} element={<MovieList/>}/>
            </Routes>
        </div>

    );
}

export default Dashboard;