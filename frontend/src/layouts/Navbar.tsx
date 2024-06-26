import {Link} from "react-router-dom";

function Navbar() {
    return (
        <header data-bs-theme="dark">
            <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <div className="container-fluid">
                    <div className="mx-1">
                        <Link to={'/'} className="text-decoration-none">
                            <img src="https://i.ibb.co/PZTxpLB/logo-navbar.png" alt="" width="32"
                                 height="32" style={{marginRight: '10px'}}/>
                        </Link>
                    </div>
                    <Link to={'/'} className="navbar-brand text-decoration-none">Filmempfehlung</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false"
                                aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <ul className="navbar-nav me-auto mb-2 mb-md-0">
                            <li className="nav-item">
                                <Link to={'/'} className="nav-link active text-decoration-none" aria-current="page">Home</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;