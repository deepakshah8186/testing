import {useState} from "react";


const Child = ({message}) => {

    const [count,setCount] = useState(0);

    const increase = () => {
        setCount(count + 1);
    }

    const onchange = (event) => {
        setCount(event.target.value);
    }

    return (
        <div>
            <h2> Child component</h2>
            <p>{count}</p>

            <input type="text" value={count} onChange={onchange}/>
            {count}
            <button onClick={increase}> Increase the count</button>
        </div>
    );
}

export default Child;