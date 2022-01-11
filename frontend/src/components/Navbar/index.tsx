import { ReactComponent as GithubIcon } from 'assets/img/github.svg'
import './styles.css'

function Navbar() {
    return (
        <header>
            <nav className='container'>
                <div className='dtmovie-nav-content'>
                    <h1>DTMovie</h1>
                    <a href="https://github.com/Caio-eng">
                        <div className='dtmovie-contact-container'>
                            <GithubIcon />
                            <p className='dtmovie-contact-link'>/caio-eng</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;