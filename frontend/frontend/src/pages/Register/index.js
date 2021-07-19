import React, { useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { FiArrowLeft } from 'react-icons/fi'


import api from '../../services/api'
import './styles.css'

import logoImg from '../../assets/logo.png'

export default function Register() {
  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [phone, setPhone] = useState('')
  const [address, setAddress] = useState('')
  const [password, setPassword] = useState('')

  const history = useHistory()

  async function handleRegister(e) {
    e.preventDefault()

    const data = {
      name,
      email,
      phone,
      address,
      password,
    }

    try {
      const response = await api.post('/usuarios', data)
      //alert(`Seu ID de acesso: ${response.data.id}`)
      alert('Cadastro feito com sucesso')

      history.push('/')
    } catch (err) {
      alert('Erro no cadastro, tente novamente')
    }
  }

  return (
    <div className="register-container">
      <div className="content">
        <section>
          <img src={logoImg} alt="Hermes logo" />
          <h1> Cadastro </h1>
          <p> Faça seu cadastro, entre na plataforma e ajude instituições a continuar trabalhando em prol de um Brasil com menos desigualdade. </p>
          <Link className="back-link" to="/">
            <FiArrowLeft size={16} color="#006BE2" />
            Voltar para o Login
          </Link>
        </section>
        <form onSubmit={handleRegister}>
          <input placeholder="Nome do Usuário" value={name} onChange={e => setName(e.target.value)} required={true} />
          <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} required={true}/>
          <input placeholder="WhatsApp" value={phone} onChange={e => setPhone(e.target.value)}  required={true}/>
          <input placeholder="Senha" type="password" value={password} onChange={e => setPassword(e.target.value)} required={true}/>
          <div className="input-group">
            <input placeholder="Endereço" value={address} onChange={e => setAddress(e.target.value)}  required={true}/>
          </div>
          <button className="button" type="submit"> Cadastrar </button>
        </form>
      </div>
    </div>
  )
}