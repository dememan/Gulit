import { ClassNames } from '@emotion/react';
import { Fragment } from 'react';
import HeaderCartButton from './HeaderCartButton';


const Header = (props) => {
  return (
    <Fragment>
      <header >
        <h1>ጊሊት Online shoping</h1>
        <div className={ClassNames['main-image']}>
             </div>
      </header>
    </Fragment>
  );
};

export default Header;
