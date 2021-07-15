import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiLogIn } from 'react-icons/fi'

import api from '../../services/api'

import './styles.css'

import logoImg from '../../assets/logo.png'
import heroesImg from '../../assets/heroes.png'

export default function Logon() {
  //const [id, setId] = useState('')
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const history = useHistory()

  async function handleLogin(e) {
    e.preventDefault()
    try {
      const response = await api.post('session', { email, password })
      localStorage.setItem('userName', response.data.name)
      localStorage.setItem('usuario', response.data)
      localStorage.setItem('email', email)
      localStorage.setItem('password', password)
      //localStorage.setItem('ongName', response.data.name)
      console.log(response.data)
      history.push('/profile')
    } catch (err) {
      alert('Usuário ou Senha inválidos')
    }
  }

  return (
    <div className="logon-container">
      <section className="form">
        <img src={logoImg} alt="Hermes Logo" />

        <form onSubmit={handleLogin}>
          <h1> Faça seu Login </h1>
          <input placeholder="Seu Email" value={email} onChange={e => setEmail(e.target.value)} required={true}/>
          <input type="password" placeholder="Senha" value={password} onChange={e => setPassword(e.target.value)} required={true} />
          <button className="button" type="submit"> Entrar </button>
          <Link className="back-link" to="/register">
            <FiLogIn size={16} color="#006BE2" />
          Não tenho cadastro
        </Link>
        </form>
      </section>
      <img className="principalImage" src={heroesImg} alt="helpers" />
    </div>
  )
}