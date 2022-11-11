package com.example.navegation.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navegation.data.DataRespository
import com.example.navegation.databinding.FragmentHomeBinding
import com.example.navegation.model.user.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter
    private lateinit var dataRepository: DataRespository
    private lateinit var viewModel: UsersViewModel

    private val userListener =
        object : Adapter.UserListener {
            override fun onItemClick(user: User) {
                val action = HomeFragmentDirections.actionHomeFragmentToUserDetailFragment(user)
                findNavController().navigate(action)
            }

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)
        dataRepository = DataRespository(requireContext())
        CoroutineScope(Dispatchers.IO).launch {
            val users = dataRepository.getUsers()
            adapter.submitList(users)
        }

    }

    fun initRecyclerView(){
        val recyclerView = binding.rvUsers
        adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        adapter.setUserListener(userListener)
        adapter.submitList(
            emptyList()
        )
    }

}