import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Dashboard from "./layouts/Dashboard.tsx";
import Navbar from "./layouts/Navbar.tsx";
import Footer from "./layouts/Footer.tsx";

function App() {

  return (
      <>
        <Navbar/>
        <Dashboard/>
          <Footer/>
      </>

  )
}

export default App
