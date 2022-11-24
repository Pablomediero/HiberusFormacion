package com.example.navegation.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navegation.app.common.ResourceState
import com.example.navegation.data.DataRepository
import com.example.navegation.databinding.FragmentHomeBinding
import com.example.navegation.domain.GetUsersUseCase
import com.example.navegation.model.user.User


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: Adapter
    private val viewModel by viewModels<UsersViewModel> {
        UsersViewModelFactory(GetUsersUseCase(DataRepository(requireContext())))
    }

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
        viewModel.getUsers()
        viewModel.getUsersLiveData().observe(viewLifecycleOwner) {usersState ->
            when(usersState){
                is ResourceState.Loading -> {
                    binding.pbLoader.visibility = View.VISIBLE
                }
                is ResourceState.Success -> {
                    binding.pbLoader.visibility = View.INVISIBLE
                    adapter.submitList(usersState.data) }
                is ResourceState.Error   -> { usersState.errorMessage}
            }
        }
    }

    fun initRecyclerView(){
        val recyclerView = binding.rvUsers
        adapter = Adapter()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        adapter.setUserListener(userListener)

    }

}